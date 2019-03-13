class Car:
    def __init__(self):
        self.pas = 0
        self.km = 0
        self.fuel = 0
        self.lim_pass = 2
        self.lim_fuel = 10

    def entrar(self):
        if self.pas < self.lim_pass:
            self.pas += 1
        else:
            print("limite de pessoas atingindo")

    def tirar(self):
        if self.pas > 0:
            self.pas -= 1
        else:
            print("nao ha ninguem no carro")

    def abastecer(self, qtd):
        self.fuel += qtd
        if (self.fuel > self.lim_fuel):
            self.fuel = self.lim_fuel

    def drive(self, distancia):
        if self.pas == 0:
            print("nao ha ninguem no carro")
            return

            fuel_needed = distancia / 10
            if (self.fuel >= fuel_needed):
                self.km += distancia
                self.fuel -= fuel_needed

    def __str__(self):
        return "pass: " + str(self.pas) + ", gas: " + str(
            self.fuel) + ", km: " + str(self.km)


carro = Car()
entrada = ""
print("digite show, in, out, fuel _qtd, drive _dist, end")
while (entrada != "end"):
    entrada = input()
    ui = entrada.split(" ")

    if ui[0] == "end":
        break
    elif entrada == "show":
        print(carro)
    elif ui[0] == "in":
        carro.entrar()
    elif ui[0] == "out":
        carro.tirar()
    elif ui[0] == "fuel":
        carro.abastecer(int(ui[1]))
    elif ui[0] == "drive":
        carro.drive(int(ui[1]))
    else:
        print("comando invalido")
