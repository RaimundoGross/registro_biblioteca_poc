package com.pruebas_software;

public enum State {
    AVAIBLE {
        public String toString(){
            return "Disponible";
        }
    },
    BORROWED {
        public String toString(){
            return "Prestado";
        }
    },
    MISSING {
        public String toString(){
            return "Perdido";
        }
    }
}
