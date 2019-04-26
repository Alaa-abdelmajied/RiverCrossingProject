package model;

import Actors.ICrosser;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class wolfsubscene extends SubScene{
	private String Font_Path="src/model/resources/kenvector_future.ttf";
	private String backimage="file:/C:/Users/Fujitsu/Desktop/wolf.png";
private  boolean ishidden;
int x=0;double z;
fxxsubscene boat;
TranslateTransition transition ;
double orgSceneX, orgSceneY;
double orgTranslateX, orgTranslateY;

	public wolfsubscene(ICrosser wolf) {
		super(new AnchorPane(), 40, 40);
		int x=0;
		prefWidth(600);
		prefHeight(400);
		BackgroundImage image=new BackgroundImage(new Image(backimage,40,40,false,true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		AnchorPane root2=(AnchorPane) this.getRoot();
		root2.setBackground(new Background(image));
		setLayoutX(1024);
		setLayoutY(310);
	}
	public void moveSubscene(boolean k) {
		

		transition =new TranslateTransition();
		transition.setDuration(Duration.seconds(0.95));
		transition.setNode(this);
		boat=new fxxsubscene();
		setOnMousePressed(circleOnMousePressedEventHandler);
	    setOnMouseDragged(circleOnMouseDraggedEventHandler);
		
		
		if(x==0) {	// System.out.println(k);

			transition.setToX(-300);
		     z=transition.getToX();

			//ishidden=true;
			
			
			x++;
		}//left bank
		else if((z<-335)&&(z>-442)&&k==true) {
			// System.out.println(k);

			transition.setToX(-650);
			//ishidden=false;
			z=transition.getToX();}
		else if((z<-538)&&(z>-653)&&k==false) {
			// System.out.println(k);

			transition.setToX(-350);
			//ishidden=false;
			z=transition.getToX();}
		

				
		
		System.out.println(z);
		 System.out.println(k);
		transition.play();
	   

		
		
	}
	public int getx() {return x;}
	EventHandler<MouseEvent> circleOnMousePressedEventHandler = 
	new EventHandler<MouseEvent>() {

	@Override
	public void handle(MouseEvent t) {
	    orgSceneX = t.getSceneX();
	    orgSceneY = t.getSceneY();
	    orgTranslateX = ((Node) t.getSource()).getTranslateX();
	    orgTranslateY = ((Node) t.getSource()).getTranslateY();
	}
	};

	EventHandler<MouseEvent> circleOnMouseDraggedEventHandler = 
	new EventHandler<MouseEvent>() {

	@Override
	public void handle(MouseEvent t) {
		//if(orgSceneX-orgTranslateX>-278) {transition.setToX(-300);transition.setToY(6);transition.play();z=transition.getToX();}
	    double offsetX = t.getSceneX() - orgSceneX;
	    double offsetY = t.getSceneY() - orgSceneY;
	    double newTranslateX = orgTranslateX + offsetX;
	    double newTranslateY = orgTranslateY + offsetY;
	    System.out.println("ofsset is"+offsetX);
	     if((offsetX>-131)) {                //-545to-1040
	    ((Node) t.getSource()).setTranslateX(newTranslateX);
	    transition.setToX(newTranslateX);transition.setToY(newTranslateY);
	    z=transition.getToX();
	    double y=transition.getToY();
	    System.out.println(" y="+y);
	    
	    System.out.println(z);
	   transition.setToY(newTranslateY);
	    ((Node) t.getSource()).setTranslateY(newTranslateY);
	    if(y>43||y<-4) {transition.setToX(-300);transition.setToY(6);transition.play();z=transition.getToX();}
	}else {transition.setToX(-300);transition.setToY(6);transition.play();z=transition.getToX();}
	     
	     
	     System.out.println("ofsset is"+offsetX);
	      if((offsetX<155)) {                //-545to-1040
	     ((Node) t.getSource()).setTranslateX(newTranslateX);
	     transition.setToX(newTranslateX);transition.setToY(newTranslateY);
	     z=transition.getToX();
	     double y=transition.getToY();
	     System.out.println(" y="+y);
	     
	     System.out.println(z);
	    transition.setToY(newTranslateY);
	     ((Node) t.getSource()).setTranslateY(newTranslateY);
	     if(y>43||y<-4) {transition.setToX(-300);transition.setToY(6);transition.play();z=transition.getToX();}
	 }else {transition.setToX(-690);transition.setToY(6);transition.play();z=transition.getToX();}

}


	};

}