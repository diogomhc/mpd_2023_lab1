package isel.mpd.painter2.model;

import java.awt.*;

public class Picture {
    // TO COMPLETE
    // adiciona uma nova forma ao contentor
    public void add(IShape shape) {

    }

    // remove a forma ”shape” do contentor. Caso a forma não exista, retorna false
    public boolean remove(IShape shape) {
        if(shape == null) return false;

        return true;
    }

    // retorna a primeira IShape do contentor que contenha o Ponto point
    // retorna null se nenhuma shape existir com esse critério
    public IShape getShape(Point p) {
        return null;
    }
}

