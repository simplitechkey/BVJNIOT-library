/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barcode.bvjniot;

/**
 *
 * @author omkarkamate
 */
public class Databasesample {
    int albumId=0;
    int artistId=0;
    String artistName="";
public Databasesample(int albumId,String artistName,int artistId) {
        this.albumId = albumId;
        this.artistId = artistId;
        this.artistName = artistName;
    }
    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}