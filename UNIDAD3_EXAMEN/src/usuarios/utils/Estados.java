package usuarios.utils;

public enum Estados {
    AGUASCALIENTES("AGUASCALIENTES", "AGU"),
    BAJA_CALIFORNIA("BAJA CALIFORNIA", "BC"),
    BAJA_CALIFORNIA_SUR("BAJA CALIFORNIA SUR", "BCS"),
    CAMPECHE("CAMPECHE", "CAMP"),
    CHIAPAS("CHIAPAS", "CHIS"),
    CHIHUAHUA("CHIHUAHUA", "CHIH"),
    COAHUILA("COAHUILA", "COAH"),
    COLIMA("COLIMA", "COL"),
    DISTRITO_FEDERAL("CDMX", "DF"),
    DURANGO("DURANGO", "DGO"),
    GUANAJUATO("GUANAJUATO", "GTO"),
    GUERRERO("GUERRERO", "GRO"),
    HIDALGO("HIDALGO", "HGO"),
    JALISCO("JALISCO", "JAL"),
    MEXICO("MEXICO", "MEX"),
    MICHOACAN("MICHOACAN", "MIC"),
    MORELOS("MORELOS", "MOR"),
    NAYARIT("NAYARIT", "NAY"),
    NUEVO_LEON("NUEVO LEON", "NL"),
    OAXACA("OXACA", "OAX"),
    PUEBLA("PUEBLA", "PUE"),
    QUERETARO("QUERETARO", "QRO"),
    QUINTANA_ROO("QUINTANA ROO", "QR"),
    SAN_LUIS_POTOSI("SAN LUIS POTOSI", "SLP"),
    SINALOA("SINALOA", "SIN"),
    SONORA("SONORA", "SON"),
    TABASCO("TABASCO", "TAB"),
    TAMAULIPAS("TAMAULIPAS", "TAM"),
    TLAXCALA("TLAXCALA", "TLAX"),
    VERACRUZ("VERACRUZ", "VER"),
    YUCATAN("YUCATAN", "YUC"),
    ZACATECAS("ZACATECAS", "ZAC");

    private final String nombre;
    private final String abreviatura;

    Estados(String nombre, String abreviatura) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

}
