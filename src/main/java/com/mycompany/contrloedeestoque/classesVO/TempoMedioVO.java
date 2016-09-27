package com.mycompany.contrloedeestoque.classesVO;

/**
 * Document   TempoMedioVO
 * @Date  05/09/2016
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
public class TempoMedioVO {
  private double media;

    public TempoMedioVO(double media) {
        this.media = media;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "TempoMedioVO{" + "media=" + media + '}';
    }
  
}