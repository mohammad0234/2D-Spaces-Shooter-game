package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemy extends Walker implements StepListener {

    private float left,right;

    private float deltaY = -0.005f;

    Vec2 startPosition;

   private static final Shape enemyShape = new PolygonShape(0.01f,1.39f, -1.45f,0.55f, -1.4f,-0.56f, -0.37f,
           -1.5f, 0.71f,-1.48f, 1.48f,0.1f, 0.05f,1.39f);

    private static final BodyImage image = new BodyImage("data/Enemies/enemyNimble.png", 3);


    public Enemy(World world) {
        super(world,enemyShape);
        addImage(image);
        world.addStepListener(this);
        startWalking(5);
        //setAlwaysOutline(true);
    }

    public void setValue(){
        startPosition = this.getPosition();
        //super.setPosition((position));
        left = startPosition.x-12f;
        right = startPosition.x+12f;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x>right){
            startWalking(-5);
            //deltaX*=-2;
        }

        if (getPosition().x<left){
            startWalking(5);
           // deltaX*=-2;
        }

        this.setPosition(new Vec2(this.getPosition().x, this.getPosition().y+ deltaY));

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
