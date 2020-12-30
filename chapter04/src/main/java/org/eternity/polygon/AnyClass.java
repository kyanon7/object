package org.eternity.polygon;

public class AnyClass {
    void anyMethod(Rectangle rectangle, int multiple){
        rectangle.setRight(rectangle.getRight()*multiple);
        rectangle.setBottom(rectangle.getBottom()*multiple);
        rectangle.setLeft(rectangle.getLeft()*multiple);
        rectangle.setTop(rectangle.getTop()*multiple);
    }
}