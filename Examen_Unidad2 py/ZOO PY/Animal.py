import random
    #clase
class Animal:
        #crear instancia
        #metodo con parametros
        def __init__(self, tipoAnimal, fechaNacimiento, fechaLlegada, peso, enfermedades, frecuenciaAlimentacion, tipoAlimentacion, vacunas):
            self.id = self.generarIdAleatorio()
            self.tipoAnimal = tipoAnimal
            self.fechaNacimiento = fechaNacimiento      #asignar 
            self.fechaLlegada = fechaLlegada
            self.peso = peso
            self.enfermedades = enfermedades
            self.frecuenciaAlimentacion = frecuenciaAlimentacion
            self.tipoAlimentacion = tipoAlimentacion
            self.vacunas = vacunas
        #metodos
        def generarIdAleatorio(self):
            num = random.randint(1, 1000)
            return "A" + str(num)
        #metodos
        def getId(self):
            return self.id
        #metodos
        def getTipoAnimal(self):
            return self.tipoAnimal
        #metodos
        def setTipoAnimal(self, tipoAnimal):
            self.tipoAnimal = tipoAnimal
        #metodos
        def getFechaNacimiento(self):
            return self.fechaNacimiento
        #metodos
        def setFechaNacimiento(self, fechaNacimiento):
            self.fechaNacimiento = fechaNacimiento
        #metodos
        def getFechaLlegada(self):
            return self.fechaLlegada
        #metodos
        def setFechaLlegada(self, fechaLlegada):
            self.fechaLlegada = fechaLlegada
        #metodos
        def getPeso(self):
            return self.peso
        #metodos
        def setPeso(self, peso):
            self.peso = peso
        #metodos
        def getEnfermedades(self):
            return self.enfermedades
        #metodos
        def setEnfermedades(self, enfermedades):
            self.enfermedades = enfermedades
        #metodos
        def getFrecuenciaAlimentacion(self):
            return self.frecuenciaAlimentacion

        def setFrecuenciaAlimentacion(self, frecuenciaAlimentacion):
            self.frecuenciaAlimentacion = frecuenciaAlimentacion

        def getTipoAlimentacion(self):
            return self.tipoAlimentacion

        def setTipoAlimentacion(self, tipoAlimentacion):
            self.tipoAlimentacion = tipoAlimentacion

        def isVacunas(self):
            return self.vacunas

        def setVacunas(self, vacunas):
            self.vacunas = vacunas

        def __str__(self):
            return f"Animal: Id: '{self.id}', Tipo Animal: '{self.tipoAnimal}', Fecha Nacimiento: '{self.fechaNacimiento}', Fecha Llegada: '{self.fechaLlegada}', 
            Peso: {self.peso}, Enfermedades: {self.enfermedades}, Frecuencia Alimentacion: '{self.frecuenciaAlimentacion}', Tipo Alimentacion: '{self.tipoAlimentacion}', 
            Vacunas: {self.vacunas}"

    # Ejemplo de uso
    # animal1 = Animal("León", "01/01/2010", "01/05/2015", 150, ["Gripe"], "2 veces al día", "Carnívoro", True)
    # print(animal1)
