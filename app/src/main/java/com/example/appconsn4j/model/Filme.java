package com.example.appconsn4j.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Filme {
    @SerializedName("nome")
    public String nomeFilme;
    @SerializedName("dtlanc")
    public Integer anoFilme;

    @NonNull
    @Override
    public String toString() {
        return this.nomeFilme;
    }
}
