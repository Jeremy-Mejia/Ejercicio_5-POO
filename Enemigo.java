class Enemigo extends Combatiente{
    
    public int vidasEnemigo(){
        int vidaEnemigo = 3;
        return vidaEnemigo;
    }

    public String NombreEnemigo(){
        String nombreEnemigo = "Enemigo normal";
        return nombreEnemigo;
    }

    public String PoderesEnemigo(){
        String poderEnemigo = "El cazador puede golpear y tirar veneno";
        return poderEnemigo;
    }

    public String AcompananteEnemigo(){
        String ACEnemigo = "Es el acompañante del Enemigo Jefe";
        return ACEnemigo; 
    }

    public void acompanante(){
    }
}