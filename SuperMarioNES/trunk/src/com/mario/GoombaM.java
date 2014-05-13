///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package com.mario;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.Timer;
//
///**
// *
// * @author lathasuraparaju
// */
//public class GoombaM {
//
//    /**
//     * @param args the command line arguments
//     */
//     public static void main(String[] args) {
//JFrame j=new JFrame();
//Mushroom obj=new Mushroom(1000,10,1400);
//j.setSize(obj.getSize());
//j.add(obj);
//j.setVisible(true);
//j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//}
//    
//}
//class Mushroom extends JPanel implements ActionListener{
//	int width, height;
//        int i=0,j=1;
//        int r=0;
//        Timer t;
//        int x,y;
//        int walk=0;
//       
//         boolean yesorno=true;
//Mushroom(int x,int y,int walk)
//{
//      // to visible the frame
//     
//     	
//
//        //to set the size
//    this.x=x;
//    this.y=y;
//   
//        setSize(800,800);
//        width=getWidth();
//     height=getHeight();
//     t=new Timer(1,this);
//     this.walk=walk;
//        t.start();
// setVisible(true);
//        
//        
//}
//public void paintComponent(Graphics g){
//    super.paintComponent(g);
//    j++;
//      try{
//          Thread.sleep(300L);
//	if(j%2==0){
//            MushroomRight(g);
//        }
//        else{
//            
//            MushroomLeft(g);
//        }
//        
//      }
//      catch (InterruptedException ex) {
//             System.out.println("fasd");
//         }
//    MushroomStand(g);
//}
//public void MushroomStand(Graphics g){
//	Graphics2D g2 = (Graphics2D)g;
//    	g2.scale(1, 1);
//       
//         
////head
//	g.setColor(new Color(104, 56, 38));
//	g.fillRect(x,y,30,8);
//		g.fillRect(x-10,y+7,50,8);
//		g.fillRect(x-20,y+15,70,8);
//		g.fillRect(x-30,y+23,90,8);
//		g.fillRect(x-40,y+31,110,8);
//		g.fillRect(x-50,y+39,130,20);
//			g.fillRect(x-60,y+55,150,20);
//			g.fillRect(x-50,y+70,130,15);
//				g.fillRect(x-40,y+85,30,10);
//				g.fillRect(x+40,y+85,30,10);
//				//body
//				g.setColor(new Color(255,187,128));
//				g.fillRect(x-10,y+85,50,10);
//				g.fillRect(x-15,y+95,60,10);
//				g.fillRect(x-15,y+105,60,10);
//				g.fillRect(x-10,y+115,50,10);
//					g.fillRect(x-5,y+125,40,10);
//					//legs
//					g.setColor(Color.BLACK);
//					//left
//						g.fillRect(x-30,y+105,15,20);
//							g.fillRect(x-23,y+115,15,20);
//							g.fillRect(x-17,y+125,20,15);
//							//left
//							g.fillRect(x+45,y+105,15,20);
//							g.fillRect(x+39,y+115,15,20);
//							g.fillRect(x+24,y+125,20,15);
//							//Eyebrows
//						g.fillRect(x-30,y+30,20,10);
//						g.fillRect(x-10,y+40,10,25);
//                                                g.fillRect(x,y+48,40,10);
//                                                g.fillRect(x+30,y+40,10,25);
//                                                g.fillRect(x+40,y+30,20,10);
//                                                //Eyes
//                                                //left eye
//                                                g.setColor(Color.white);
//                                                g.fillRect(x-20,y+40,10,30);
//                                                g.fillRect(x-20,y+65,30,10);
//                                                g.fillRect(x,y+58,10,16);
//                                                //right eye
//						    g.fillRect(x+40,y+40,10,30);
//                                                g.fillRect(x+20,y+65,30,10);
//                                                g.fillRect(x+20,y+58,10,16);
//}
//public void MushroomRight(Graphics g){
//   Graphics2D g2 = (Graphics2D)g;
//    	g2.scale(0.25, 0.25);
//    
//    //head
//      
//	         
////head
//	g.setColor(new Color(104, 56, 38));
//	g.fillRect(x,y,30,8);
//		g.fillRect(x-10,y+7,50,8);
//		g.fillRect(x-20,y+15,70,8);
//		g.fillRect(x-30,y+23,90,8);
//		g.fillRect(x-40,y+31,110,8);
//		g.fillRect(x-50,y+39,130,20);
//			g.fillRect(x-60,y+55,150,20);
//			g.fillRect(x-50,y+70,130,15);
//				g.fillRect(x-40,y+85,30,10);
//				g.fillRect(x+40,y+85,30,10);
//				//body
//				g.setColor(new Color(255,187,128));
//				g.fillRect(x-10,y+85,50,10);
//				g.fillRect(x-15,y+95,60,10);
//				g.fillRect(x-15,y+105,60,10);
//				g.fillRect(x-10,y+115,50,10);
//					g.fillRect(x-5,y+125,40,10);
//					//legs
//					g.setColor(Color.BLACK);
//					//left
//						g.fillRect(x-30,y+105,15,20);
//							g.fillRect(x-23,y+115,15,20);
//							g.fillRect(x-17,y+125,20,15);
//							//right
//							g.fillRect(x+45,y+105,30,40);
//							g.fillRect(x+39,y+115,30,40);
//							g.fillRect(x+24,y+125,40,30);
//							//Eyebrows
//						g.fillRect(x-30,y+30,20,10);
//						g.fillRect(x-10,y+40,10,25);
//                                                g.fillRect(x,y+48,40,10);
//                                                g.fillRect(x+30,y+40,10,25);
//                                                g.fillRect(x+40,y+30,20,10);
//                                                //Eyes
//                                                //left eye
//                                                g.setColor(Color.white);
//                                                g.fillRect(x-20,y+40,10,30);
//                                                g.fillRect(x-20,y+65,30,10);
//                                                g.fillRect(x,y+58,10,16);
//                                                //right eye
//						    g.fillRect(x+40,y+40,10,30);
//                                                g.fillRect(x+20,y+65,30,10);
//                                                g.fillRect(x+20,y+58,10,16);
//}
//public void MushroomLeft(Graphics g){
//    Graphics2D g2 = (Graphics2D)g;
//     g2.scale(0.25, 0.25);
//   
//             
////head
//	g.setColor(new Color(104, 56, 38));
//	g.fillRect(x,y,30,8);
//		g.fillRect(x-10,y+7,50,8);
//		g.fillRect(x-20,y+15,70,8);
//		g.fillRect(x-30,y+23,90,8);
//		g.fillRect(x-40,y+31,110,8);
//		g.fillRect(x-50,y+39,130,20);
//			g.fillRect(x-60,y+55,150,20);
//			g.fillRect(x-50,y+70,130,15);
//				g.fillRect(x-40,y+85,30,10);
//				g.fillRect(x+40,y+85,30,10);
//				//body
//				g.setColor(new Color(255,187,128));
//				g.fillRect(x-10,y+85,50,10);
//				g.fillRect(x-15,y+95,60,10);
//				g.fillRect(x-15,y+105,60,10);
//				g.fillRect(x-10,y+115,50,10);
//					g.fillRect(x-5,y+125,40,10);
//					//legs
//					g.setColor(Color.BLACK);
//					//left
//						g.fillRect(x-30,y+105,30,40);
//							g.fillRect(x-23,y+115,30,40);
//							g.fillRect(x-17,y+125,40,30);
//							//right
//							g.fillRect(x+45,y+105,15,20);
//							g.fillRect(x+39,y+115,15,20);
//							g.fillRect(x+24,y+125,20,15);
//							//Eyebrows
//						g.fillRect(x-30,y+30,20,10);
//						g.fillRect(x-10,y+40,10,25);
//                                                g.fillRect(x,y+48,40,10);
//                                                g.fillRect(x+30,y+40,10,25);
//                                                g.fillRect(x+40,y+30,20,10);
//                                                //Eyes
//                                                //left eye
//                                                g.setColor(Color.white);
//                                                g.fillRect(x-20,y+40,10,30);
//                                                g.fillRect(x-20,y+65,30,10);
//                                                g.fillRect(x,y+58,10,16);
//                                                //right eye
//						    g.fillRect(x+40,y+40,10,30);
//                                                g.fillRect(x+20,y+65,30,10);
//                                                g.fillRect(x+20,y+58,10,16);                                         g.fillRect((width/2)+20,(height/2)+58,10,16);
//}
//
//    @Override
//    public void actionPerformed(ActionEvent e)
//    {
//       
//        if(walk>getWidth()){
//        if(x<=walk&&yesorno){//till where do you want the goomba to move
//            if(x<walk){
//                 try {
//                    Thread.sleep(100L);
//                }
//                catch(InterruptedException ex){
//                    System.out.println();
//                }
//            x+=10;
//             
//            }
//            else if(x==walk){
//                 try {
//                    Thread.sleep(100L);
//                }
//                catch(InterruptedException ex){
//                    System.out.println();
//                }
//                yesorno=false;
//                x+=10;
//                
//            }
//        
//         }
//        
//       
//        else if(x>0&&!yesorno){
//            if(x>getWidth()){
//                try {
//                    Thread.sleep(100L);
//                }
//                catch(InterruptedException ex){
//                    System.out.println();
//                }
//           x-=10;
//            
//            }
//            else if(x==getWidth()){
//                 try {
//                    Thread.sleep(100L);
//                }
//                catch(InterruptedException ex){
//                    System.out.println();
//                }
//                yesorno=true;
//                x=getWidth();
//               
//            }
//            
//        }
//        }
//        else{
//             t.stop();
//        }
//        
//        
//        
//        
//         
//   
//   
//           
//        repaint();
//    }
//}
//
//
//
