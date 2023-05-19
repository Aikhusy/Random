/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HAPE
 */
public class Menu implements IQuery {
    private int idMenu;
    private String namaMenu;
    private double harga;
    private Kategori kategori;
    
    public Menu(){
        
    }
    public Menu(String namaMenu,double harga,Kategori kategori){
        this.namaMenu=namaMenu;
        this.harga=harga;
        this.kategori=kategori;
    }
    public int getIdMenu(){
        return idMenu;
    }
    public String getNamaMenu(){
        return namaMenu;
    }
    public double getHarga(){
        return harga;
    }
    public Kategori getKategori(){
        return kategori;
    }
    public void setIdMenu(int id){
        idMenu=id;
    }
    public void setNamaMenu(String nama){
        namaMenu=nama;
    }
    public void setHarga(double harga){
        this.harga=harga;
    }
    public void setKategori(Kategori k){
        this.kategori=k;
    }
    public Menu getByName(String name){
        Menu k= new Menu();
        ResultSet rs=DBHelper.selectQuery("select * from menu"+" where namaMenu = '"+name+"'");
        try{
            while(rs.next()){
                k=new Menu();
                Kategori ka= new Kategori();                          
                
                k.setIdMenu(rs.getInt("idMenu"));
                k.setNamaMenu(rs.getString("namaMenu"));
                k.setHarga(rs.getInt("harga"));
                k.setKategori(ka.getById(rs.getInt("idKategori")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return k;
    }
    public Menu getById(int id){
        Menu k= new Menu();
        ResultSet rs=DBHelper.selectQuery("select * from menu where idMenu = '"+id+"'");
        try{
            while(rs.next()){
                k=new Menu();
                Kategori ka= new Kategori();                          
                
                k.setIdMenu(rs.getInt("idMenu"));
                k.setNamaMenu(rs.getString("namaMenu"));
                k.setHarga(rs.getInt("harga"));
                k.setKategori(ka.getById(rs.getInt("idKategori")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return k;
    }
    public ArrayList<Menu> search (String keyword){
        ArrayList<Menu> listKategori = new ArrayList();
        
        String sql="select * from menu m inner join kategori k on k.idKategori=m.idKategori where"
            
            + " m.namaMenu LIKE '%"+keyword+"%'"
            + " or m.harga LIKE '%"+keyword+"%'"
            + " or k.namaKategori LIKE '%"+keyword+"%'"
            + " or k.keterangan LIKE '%"+keyword+"%'";
        
        ResultSet rs=DBHelper.selectQuery(sql);
        try{
            while(rs.next()){
                Menu k=new Menu();
                Kategori ka=new Kategori();
                
                k.setKategori(ka.getById(rs.getInt("idKategori")));
                k.setIdMenu(rs.getInt("idMenu"));
                k.setNamaMenu(rs.getString("namaMenu"));
                k.setHarga(rs.getInt("harga"));
                
                
                listKategori.add(k);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listKategori;
    }
    public ArrayList<Menu> getAll(){
        ArrayList<Menu> listMenu= new ArrayList<Menu>();
        ResultSet rs=DBHelper.selectQuery(
                "select * from menu ");
        try{
            while(rs.next()){
                Menu k=new Menu();
                Kategori ka=new Kategori();
                
                
                k.setIdMenu(rs.getInt("idMenu"));
                k.setNamaMenu(rs.getString("namaMenu"));
                k.setHarga(rs.getInt("harga"));
                k.setKategori(ka.getById(rs.getInt("idKategori")));
                
                listMenu.add(k);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listMenu;
    }
    @Override
    public String toString(){
        return namaMenu;
    }
    public void save(){
        if(getById(idMenu).getIdMenu()==0){
            String SQL = " INSERT into menu (namaMenu,harga,idKategori) values "
                    + "('"
                    +this.namaMenu+"','"
                    +this.harga+"','"
                    +this.kategori.getIdKategori()+"')";
            this.idMenu =DBHelper.insertQueryGetId(SQL);
            
        }else{
            String SQL = "Update menu set "
                    + "idMenu='"+idMenu+"',"
                    + "namaMenu='"+namaMenu+"',"
                    + "idKategori='"+kategori.getIdKategori()+"',"
                    + "harga='"+harga+"'"
                    + "where idMenu='"+idMenu+"'";
            DBHelper.executeQuery(SQL);
        }   
    }
    public void delete(){
        String SQL = "delete from menu where idMenu ='"+this.idMenu +"'";
        DBHelper.executeQuery(SQL);
    }
}
