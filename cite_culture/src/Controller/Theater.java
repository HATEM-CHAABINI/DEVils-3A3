/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Thomas
 */
public class Theater {
    
    private MovieShow show1;
    private MovieShow show2;
    private MovieShow show3;
    private MovieShow show4;
    
    public Theater() {
        show1 = new MovieShow();
        show2 = new MovieShow();
        show3 = new MovieShow();
        show4 = new MovieShow();
    }
    
    public Theater(MovieShow mov1, MovieShow mov2, MovieShow mov3, 
            MovieShow mov4) {
        show1 = mov1;
        show2 = mov2;
        show3 = mov3;
        show4 = mov4;
    }
    
    public void setFirstShow(MovieShow movie) {
        show1 = movie;
    }
    
    public void setSecondShow(MovieShow movie) {
        show2 = movie;
    }
    
    public void setThirdShow(MovieShow movie) {
        show3 = movie;
    }
    
    public void setFourthShow(MovieShow movie) {
        show4 = movie;
    }
    
    public MovieShow getFirstShow() {
        return show1;
    }
    
    public MovieShow getSecondShow() {
        return show2;
    }
    
    public MovieShow getThirdShow() {
        return show3;
    }
    
    public MovieShow getFourthShow() {
        return show4;
    }
}
