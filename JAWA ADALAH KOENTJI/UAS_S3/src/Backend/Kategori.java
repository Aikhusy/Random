/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author HAPE
 */
public class Kategori implements IQuery {
    private int idKategori;
    private String namaKategori,keterangan;
    
    public Kategori(){   
    }
    public Kategori(String namaKategori,String keterangan){
        this.namaKategori=namaKategori;
        this.keterangan=keterangan;
    }
    
    public int getIdKategori(){
        return idKategori;
    }
    public String getNamaKategori(){
        return namaKategori;
    }
    public String getKeterangan(){
        return keterangan;
    }
    public void setIdKategori(int idKategori){
        this.idKategori=idKategori;
    }
    public void setNamaKategori(String namaKategori){
        this.namaKategori=namaKategori;
    }
    public void setKeterangan(String keterangan){
        this.keterangan=keterangan;
    }
    
    public Kategori getById(int id){
        Kategori k= new Kategori();
        ResultSet rs=DBHelper.selectQuery("select * from kategori where idKategori = '"+id+"'");
        try{
            while(rs.next()){
                k=new Kategori();
                k.setIdKategori(rs.getInt("idKategori"));
                k.setNamaKategori(rs.getString("namaKategori"));
                k.setKeterangan(rs.getString("keterangan"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return k;
    }
    
        public Kategori getByName(String id){
        Kategori k= new Kategori();
        ResultSet rs=DBHelper.selectQuery("select * from kategori where namaKategori = '"+id+"'");
        try{
            while(rs.next()){
                k=new Kategori();
                k.setIdKategori(rs.getInt("idKategori"));
                k.setNamaKategori(rs.getString("namaKategori"));
                k.setKeterangan(rs.getString("keterangan"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return k;
    }
    public ArrayList<Kategori> getAll(){
        ArrayList<Kategori> listKategori= new ArrayList<Kategori>();
        ResultSet rs=DBHelper.selectQuery("select * from kategori");
        try{
            while(rs.next()){
                Kategori k=new Kategori();
                k.setIdKategori(rs.getInt("idKategori"));
                k.setNamaKategori(rs.getString("namaKategori"));
                k.setKeterangan(rs.getString("keterangan"));
                
                listKategori.add(k);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listKategori;
    }
    public String toString(){
        return namaKategori;
    }
    public ArrayList<Kategori> search (String keyword){
        ArrayList<Kategori> listKategori = new ArrayList();
        
        String sql="select * from kategori where "
            + "namaKategori LIKE '%"+keyword+"%'"
            + " or keterangan LIKE '%"+keyword+"%'";
        
        ResultSet rs=DBHelper.selectQuery(sql);
        try{
            while(rs.next()){
                Kategori k=new Kategori();
                k.setIdKategori(rs.getInt("idKategori"));
                k.setNamaKategori(rs.getString("namaKategori"));
                k.setKeterangan(rs.getString("keterangan"));
                
                listKategori.add(k);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listKategori;
    }
    @Override
    public void save(){
        if(getById(idKategori).getIdKategori()==0){
            String SQL = " INSERT into kategori (namaKategori,keterangan) values "
                    + "('"+this.namaKategori+"','"+this.keterangan+"')";
            this.idKategori =DBHelper.insertQueryGetId(SQL);
            
        }else{
            String SQL = "Update kategori set "
                    + "namaKategori='"+namaKategori+"',keterangan='"+keterangan+"'"
                    + "where idKategori='"+idKategori+"'";
            DBHelper.executeQuery(SQL);
        }   
    }
    @Override
    public void delete(){
        String SQL = "delete from kategori where idKategori ='"+this.idKategori +"'";
        DBHelper.executeQuery(SQL);
    }
}
