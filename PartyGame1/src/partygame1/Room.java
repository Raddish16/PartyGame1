/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

/**
 *
 * @author brendanwilhelm
 */
public class Room {

    protected int width, height;
    protected int[][] room;

    public Room(int width, int height) {
        this.width = width;
        this.height = height;
        genRoom(width, height);
    }

    public void genRoom(int width, int height) {

        //This randomly generates a room out of numbers, which we can then transpose into graphics later
        //0 = empty space, 1 = dirt, 2 = item, 3 = enemy, 9 = entrance/exit aka empty space but it's how we connect the boxes
        //I'm going to try to make holes in the tops and bottoms of the floors also
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (r == height - 1 || r == height - 2) {
                    room[r][c] = 1;
                } else if (c == width - 1 || c == 0) {
                    room[r][c] = 1;
                } else if (room[r-1][c] == 1 && room [r][c] == 0) {
                    if((int)(Math.random()*6) == 0){
                        room[r][c] = 3;
                    }else if((int)(Math.random()*4) == 0){
                        room[r][c] = 2;
                    }
                } /*else if () {
                    room[r][c] =;
                } else if () {
                    room[r][c] =;
                } else if () {
                    room[r][c] =;
                } else if () {
                    room[r][c] =;
                } else {
                    room[r][c] = 0;
                }*/
            }
        }
        //Entrance and exit, entrance on left, exit on right
        int Ent = (int) (Math.random() * height);
        int Ex = (int) (Math.random() * height);
        room[Ent][0] = 9;
        room[Ex][width - 1] = 9;
        if((int)(Math.random()*4) == 0){
            room[height - 1][(int)(width/2)] = 9;
        }
        if((int)(Math.random()*4) == 0){
            room[0][(int)(width/2)] = 9;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getRoom() {
        return room;
    }

}
