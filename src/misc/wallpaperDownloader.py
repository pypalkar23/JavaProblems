#!/usr/bin/python3
from urllib3 import PoolManager
from urllib3.exceptions import MaxRetryError
from time import sleep
from json import loads
import gi
from sys import exit
from os import path,environ,makedirs,system
gi.require_version("Gtk","3.0")
from gi.repository import Gio
from gi.repository import Gtk

JSON_URL="http://www.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1&mkt=en-IN"
IMAGE_URL_FORMAT="http://www.bing.com{0}_{1}x{2}.jpg"
WALLPAPER_DIRECTORY=path.join(environ['HOME'],'Pictures','Bing')

def getFileUri(imagePath):
    return 'file://{0}'.format(imagePath)

def setGsetting(schema, key, value):
    gsettings = Gio.Settings.new(schema)
    gsettings.set_string(key, value)
    gsettings.apply()

def changeBackgroundGnome(imagePath):
    setGsetting('org.gnome.desktop.background', 'picture-uri',
        getFileUri(imagePath))

def change_screensaver(imagePath):
    setGsetting('org.gnome.desktop.screensaver', 'picture-uri',
                 getFileUri(imagePath))

def writeImageToPath(pageObject,imagePath):
    try:
        with open(imagePath,'wb') as out:
            while True:
                data=pageObject.read(8096)
                if(not data):
                    break
                out.write(data)
    except IOError:
            exit(-1)


def downloadAndSaveImage(imageUrl,imagePath):
    try:
        http=PoolManager()
        #print("Calling")
        pageObject=http.request('GET',imageUrl,preload_content=False)
        if(pageObject.status==200):
            writeImageToPath(pageObject,imagePath)
            pageObject.release_conn()
        else:
            exit(-1)
    except MaxRetryError:
        #print("Cannot Connect")
        exit(-1)

def setAsWallpaper(imagePath):
    changeBackgroundGnome(imagePath)


def getImageUrl(imageResolution):
    try:
        http=PoolManager()
        #print("Calling")
        pageObject=http.request('GET',JSON_URL)
        if(pageObject.status==200):
            pageSource=pageObject.data.decode('utf-8')
            jsonSource=loads(pageSource)
            urlbase=jsonSource['images'][0]['urlbase']
            pageObject.release_conn()
            return IMAGE_URL_FORMAT.format(urlbase,imageResolution[0],imageResolution[1])
        else:
            exit(-1)
    except MaxRetryError:
        #print("Cannot Connect")
        exit(-1)
        

def createDirectory():
    try:
        makedirs(WALLPAPER_DIRECTORY)
    except OSError:
        exit(-1)

def get_resolution():
    defaultWidth=1920
    defaultHeight=1080
    configWidth=0
    configHeight=0
    window=Gtk.Window()
    screen=window.get_screen()
    configWidth=screen.get_width()
    configHeight=screen.get_height()

    if(configWidth<=0 or configHeight<=0):
        return (defaultWidth,defaultHeight)
    return (configWidth,configHeight)

def checkExistance(imagePath):
    if(path.exists(imagePath)):
        return True
    return False


def checkDirectoryExists():
    if(not path.exists(WALLPAPER_DIRECTORY)):
        createDirectory()

    
def main():
    #check for wallpapers directory else create it
    checkDirectoryExists()

    #wait for internet connection
    system("sleep 5")
    imageResolution=get_resolution()
    imageUrl=getImageUrl(imageResolution)

    imageName=imageUrl.split("/")[-1]
    imagePath=path.join(WALLPAPER_DIRECTORY,imageName)
    if(not checkExistance(imagePath)):
        #else save it
        downloadAndSaveImage(imageUrl,imagePath)
        #set it as a wallpaper
        setAsWallpaper(imagePath)
    else:
        #print("WallpaperExists")
        pass
    exit(-1)
    

if __name__=='__main__':
    main()


    

