class Visita:
  counter = 1

  def __init__(self, guia, visitantes, costoTotal, fechaVisita, cantidadNinos, cantidadAdultos):
      self.id = "VIS" + str(Visita.counter)
      Visita.counter += 1
      self.guia = guia
      self.visitantes = visitantes
      self.costoTotal = costoTotal
      self.fechaVisita = fechaVisita
      self.cantidadNinos = cantidadNinos
      self.cantidadAdultos = cantidadAdultos

  def getId(self):
      return self.id

  def getGuia(self):
      return self.guia

  def setGuia(self, guia):
      self.guia = guia

  def getVisitantes(self):
      return self.visitantes

  def setVisitantes(self, visitantes):
      self.visitantes = visitantes

  def getCostoTotal(self):
      return self.costoTotal

  def setCostoTotal(self, costoTotal):
      self.costoTotal = costoTotal

  def getFechaVisita(self):
      return self.fechaVisita

  def setFechaVisita(self, fechaVisita):
      self.fechaVisita = fechaVisita

  def getCantidadNinos(self):
      return self.cantidadNinos

  def setCantidadNinos(self, cantidadNinos):
      self.cantidadNinos = cantidadNinos

  def getCantidadAdultos(self):
      return self.cantidadAdultos

  def setCantidadAdultos(self, cantidadAdultos):
      self.cantidadAdultos = cantidadAdultos

  def __str__(self):
      return f"Visita: Id: '{self.id}', Guia: '{self.guia}', Visitantes: {self.visitantes}, Costo Total: {self.costoTotal}, Fecha Visita: '{self.fechaVisita}', Cantidad Ninos: {self.cantidadNinos}, Cantidad Adultos: {self.cantidadAdultos}"
