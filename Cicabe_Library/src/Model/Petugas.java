/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Naufal
 */
public class Petugas {
    private String NIG;
    private String nama;
    private String username;
    private String password;
    
    public Petugas (String NIG, String nama, String username, String password){
        this.NIG = NIG;
        this.nama = nama;
        this.username = username;
        this.password = password;
    } 

    /**
     * @return the NIG
     */
    public String getNIG() {
        return NIG;
    }

    /**
     * @param NIG the NIG to set
     */
    public void setNIG(String NIG) {
        this.NIG = NIG;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
    //method sisanya

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
