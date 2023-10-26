package com.geology_quiz_and_guide.mineralogy.ui.guide;
public class MineralesAdapter2 {
    final static class Minerales {
        private final String id;
        private final String Nombre;
        private final String Grupo;
        public Minerales(String id, String Nombre, String Grupo) {
            this.id = id;
            this.Nombre = Nombre;
            this.Grupo = Grupo;
        }
        public String getId() {
            return id;
        }
        public String getNombre() {
            return Nombre;
        }
        public String getTipo() {
            return Grupo;
        }
    }
}

