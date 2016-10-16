package model;




public class Game {

    private Dificulty BEGINNER;
    private Dificulty INTERMEDIATE;
    private Dificulty ADVANCED;
    
    private enum Dificulty {
        BEGINNER, INTERMEDIATE, ADVANCED;
    }  

    private Dificulty dificulty;
    private Grid grid;
    
     
    public Game() {
        this.setDificulty(Dificulty.BEGINNER);
        this.init();
    }
    
    public void init() {
        
        int width = 0;
        int height = 0;
        int bombs = 0;
        
        // Configure Dificulty 
        switch (dificulty) {
            case BEGINNER:      width =  9; height = 9; bombs = 10; break;
            case INTERMEDIATE:  width =  16; height = 16; bombs = 40; break;
            case ADVANCED:      width =  30; height = 16; bombs = 99; break;
            default: // Exception
        }
        
        // Initialize Grid
        grid = new Grid(width, height, bombs);
    }
    
    
    public void setDificulty(Dificulty newDificulty) {
        dificulty = newDificulty;
    }
    
    public Dificulty getDificulty() {
        return this.dificulty;
    }
    
    public Grid getGrid() {
        return this.grid;
    }
}
