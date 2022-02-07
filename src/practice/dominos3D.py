def pile_ct(nvalues): 
  """Return number of distinct ways to pile 2N 1x1x2 
  bricks in a 2x2 column with N layers based on the 
  distinct ways of orienting the bricks. 
  """ 
  res=[]
  for N in nvalues:
    ct = 0 
    for i in range(2**(N-1), 2**N): 
      bp = i      
      product = 1 
      while bp:    
        product *= 2 if bp&1 else 5 if bp&2 else 4 
        r = 0  
        while r==0: 
            bp, r = divmod(bp, 2) 
      ct += product 
    res.append(ct)


print(pile_ct(1))
print(pile_ct(2))
print(pile_ct(3))
print(pile_ct(4))
print(pile_ct(5))
print(pile_ct(6))