package ch.chrisport.adventofcode;

class Claim {
    final int id;
    final int marginTop;
    final int marginLeft;
    final int height;
    final int width;

    Claim(int id, int marginTop, int marginLeft, int height, int width) {
        this.id = id;
        this.marginTop = marginTop;
        this.marginLeft = marginLeft;
        this.height = height;
        this.width = width;
    }
}