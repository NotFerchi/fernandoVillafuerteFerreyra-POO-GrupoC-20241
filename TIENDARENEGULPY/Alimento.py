from Alimento import Producto  # Suponiendo que Producto es una clase existente en otro archivo llamado producto.py

class Alimento(Producto):
    def __init__(self, nombre, precio, fecha_importacion, numero_serie, fecha_caducidad, calorias, stock):
        super().__init__(nombre, precio, fecha_importacion, numero_serie, stock)
        self.fecha_caducidad = fecha_caducidad
        self.calorias = calorias

    def get_fecha_caducidad(self):
        return self.fecha_caducidad

    def set_fecha_caducidad(self, fecha_caducidad):
        self.fecha_caducidad = fecha_caducidad

    def get_calorias(self):
        return self.calorias

    def set_calorias(self, calorias):
        self.calorias = calorias

    # Método específico para Alimento
    def informacion_nutricional(self):
        # Implementación para mostrar información nutricional del alimento
        print("Información nutricional de", self.nombre + ":", self.calorias, "calorías")
