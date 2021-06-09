#!/usr/bin/python3
from subprocess import Popen
from json import loads
from datetime import datetime
from requests import get
from getpass import getuser
from os import path, mkdir ,linesep
from logging import getLogger,handlers,Formatter,DEBUG,basicConfig
from traceback import print_exc

COWIN_BASE_DIRECTORY = "/home/{}/Cowin/".format(getuser())
COWIN_DATA_DIRECTORY = COWIN_BASE_DIRECTORY+"data/"
COWIN_LOGS_DIRECTORY = COWIN_BASE_DIRECTORY+"logs/"

COWIN_URL_STR = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict"
DISTRICT_ID_INT = 392  # thane
CENTERS_JSON_KEY = 'centers'
PINCODE_JSON_KEY = 'pincode'
SESSIONS_JSON_KEY = 'sessions'
AVAILABLE_CAPACITY_JSON_KEY = 'available_capacity'
MIN_AGE_LIMIT_JSON_KEY = 'min_age_limit'
CENTER_NAME_JSON_KEY = 'name'
ADDRESS_JSON_KEY = 'address'
DATE_JSON_KEY = 'date'

centreRecord = "Name: {}\nDate: {}\nAge: {}\nAvailable Capacity: {}\nAddress:{}\n----------\n"

WEB_HEADERS = {
    'User-Agent':
    'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36'
}

def createDirectory(directory_path):
    if not path.exists(directory_path):
        mkdir(directory_path)


def getCowinData():
    resp={}
    today_date_str = datetime.today().strftime("%d-%m-%Y")
    payload = {"district_id": DISTRICT_ID_INT, "date": today_date_str}
    http_req = get(COWIN_URL_STR, params=payload, headers=WEB_HEADERS)
    if(http_req.status_code==200):
        resp = http_req.content
    return resp   


def parseCowinResp(resp):
    pincodeMap = {18:[],45:[]}
    centreList = []
    json_resp = loads(resp)
    if CENTERS_JSON_KEY in json_resp:
        center_list = json_resp[CENTERS_JSON_KEY]
        for center in center_list:
            if PINCODE_JSON_KEY in center and str(center[PINCODE_JSON_KEY]).startswith("40060"):
                logger.info(center)
                if SESSIONS_JSON_KEY in center:
                    for session in center[SESSIONS_JSON_KEY]:
                        if AVAILABLE_CAPACITY_JSON_KEY in session and session[AVAILABLE_CAPACITY_JSON_KEY] > 0: 
                            if session[MIN_AGE_LIMIT_JSON_KEY] == 18:
                                pincodeMap[18].append(str(center[PINCODE_JSON_KEY]))
                            else:
                                pincodeMap[45].append(str(center[PINCODE_JSON_KEY]))
                            centreList.append(centreRecord.format(center[CENTER_NAME_JSON_KEY],session[AVAILABLE_CAPACITY_JSON_KEY],session[DATE_JSON_KEY],session[AVAILABLE_CAPACITY_JSON_KEY],center[ADDRESS_JSON_KEY]))
    return pincodeMap, centreList

def createAndWriteRecordsToFile(centerList):
    createDirectory(COWIN_DATA_DIRECTORY)
    fileNameToWriteTo= "COWIN-"+datetime.today().strftime("%d-%m-%Y-%H-%M-%S")+".txt"
    if(len(centerList) > 0):
        with open(COWIN_DATA_DIRECTORY+fileNameToWriteTo,"w",encoding = 'utf-8') as f:
            for centerInfo in centerList:
                f.writelines(centerInfo)   

def showNotification(pincodeMap):
    msg=""
    if(len(pincodeMap[18])>0):
        msg +="18+: "+",".join(pincodeMap[18])+linesep
    if(len(pincodeMap[45])>0):
        msg +="45+: "+",".join(pincodeMap[45])
    if(len(msg)>0):         
        Popen(['notify-send', 'Appointment/s Available', msg])

def main():
    global logger
    createDirectory(COWIN_BASE_DIRECTORY)
    createDirectory(COWIN_DATA_DIRECTORY)
    createDirectory(COWIN_LOGS_DIRECTORY)
    logger= getLogger("cowinchecker.py")
    basicConfig(level=DEBUG)
    log_format = Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
    log_handler = handlers.TimedRotatingFileHandler(COWIN_LOGS_DIRECTORY+"cowin.log",when='midnight',interval=1,backupCount=5)
    log_handler.setFormatter(log_format)
    logger.addHandler(log_handler)
    try:
         logger.info("Cowin Script Started")
         resp = getCowinData()
         #resp = sample_resp
         pincodeMap,centreList = parseCowinResp(resp)
         showNotification(pincodeMap)
         createAndWriteRecordsToFile(centreList)
         logger.info("Script Finished->Slots available for 18 & 45 at {},{} places".format(len(pincodeMap[18]),len(pincodeMap[45])))
    except Exception:
        logger.exception("Error in Cowin Script")  
        print_exc()
        Popen(['notify-send', 'Cowin Script Error', "Check Logs"])
    
if __name__=='__main__':
    main()