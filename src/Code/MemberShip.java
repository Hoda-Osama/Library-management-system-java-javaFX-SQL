/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author Huda Osama
 */
public interface MemberShip {
    String[] mType={"Silver","Gold","Daimon"};
    boolean isSeliver(int id);
    boolean  isGold(int id);
    boolean  isDaimon(int id);
    
}
