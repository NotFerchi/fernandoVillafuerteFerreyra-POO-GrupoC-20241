from datetime import datetime

class Mantenimiento:
    def __init__(self, empleadoEncargado, idAnimal, procesoRealizado, observaciones):
        self.empleadoEncargado = empleadoEncargado
        self.idAnimal = idAnimal
        self.procesoRealizado = procesoRealizado
        self.observaciones = observaciones
        self.fechaProceso = self.obtenerFechaActual()

    def obtenerFechaActual(self):
        return datetime.now().strftime("%Y-%m-%d %H:%M:%S")

    # Getters and Setters
    def empleadoEncargado(self):
        return self._empleadoEncargado

    def empleadoEncargado(self, empleadoEncargado):
        self._empleadoEncargado = empleadoEncargado


    def idAnimal(self):
        return self._idAnimal

    @idAnimal.setter
    def idAnimal(self, idAnimal):
        self._idAnimal = idAnimal

    def procesoRealizado(self):
        return self._procesoRealizado

    def procesoRealizado(self, procesoRealizado):
        self._procesoRealizado = procesoRealizado

    def fechaProceso(self):
        return self._fechaProceso

    def fechaProceso(self, fechaProceso):
        self._fechaProceso = fechaProceso

    def observaciones(self):
        return self._observaciones

    def observaciones(self, observaciones):
        self._observaciones = observaciones