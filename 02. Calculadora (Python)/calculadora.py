class Calc:
  def __init__(self, batMax):
    self.battery = 0
    self.batteryMax = batMax

  def charge(self, value):
    self.battery += value
    if (self.battery > self.batteryMax):
      self.battery = self.batteryMax

  def gastarBateria(self, battery, a, b):
    if self.battery == 0:
      print("bateria insufieciente")
      return False
    print ("a+b")
    return True

  def somar(self, a, b):
    if self.battery > 0:
      self.battery -= 1
      total = a + b
      print(total)
    else:
      print("bateria insuficiente")
  
  def dividir(self, a, b):
    if self.battery > 0:
      self.battery -= 1
      total = a/b
      print(total)
    if total == 0:
      print("erro")  
    else:
      print("bateria insuficiente")

  def __str__(self):
    return "battery = " + str(self.battery) + "/" + str(self.batteryMax)

calc = Calc(0)
print("show, init _maxCharge, charge _value, sum _a _b, div _a _b")
while True:
  ui = input().split(" ")
  if ui[0]== "end":
    break
  elif ui[0] == "init":
    calc = Calc(int(ui[1]))
  elif ui[0] == "charge":
    calc.charge(int(ui[1]))
  elif ui[0] == "sum":
    calc.somar(int(ui[1]), int(ui[2]))
  elif ui[0] == "div":
    calc.dividir(int(ui[1]), int(ui[2]))
  elif ui[0]=="show":
    print(calc)
  else:
    print("comando invalido")