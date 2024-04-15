from Belleza import Producto  # Suponiendo que Producto es una clase existente en otro archivo llamado producto.py

class Belleza(Producto):
    def __init__(self, nombre, precio, fecha_importacion, numero_serie, es_organico, stock):
        super().__init__(nombre, precio, fecha_importacion, numero_serie, stock)
        self.es_organico = es_organico

    def get_es_organico(self):
        return self.es_organico

    def set_es_organico(self, es_organico):
        self.es_organico = es_organico
