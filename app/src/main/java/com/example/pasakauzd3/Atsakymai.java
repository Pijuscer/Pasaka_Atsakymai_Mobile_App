package com.example.pasakauzd3;

import java.util.List;

public class Atsakymai {

    private final String PirmasKlausimas;
    private final String AntrasKlausimas;
    private List<String> TreciasKlausimas;
    private List<String> KetvirtasKlausimas;
    private final String PenktasKlausimas;
    private final String SestasKlausimas;
    private final String SeptintasKlausimas;
    private List<String> AstuntasKlausimas;
    private List<String> DevintasKlausimas;
    private final String DesimtasKlausimas;

    public Atsakymai(String PirmasKlausimas, String AntrasKlausimas, List<String> TreciasKlausimas, List<String> KetvirtasKlausimas, String PenktasKlausimas, String SestasKlausimas, String SeptintasKlausimas, List<String> AstuntasKlausimas, List<String> DevintasKlausimas, String DesimtasKlausimas) {
        this.PirmasKlausimas = PirmasKlausimas;
        this.AntrasKlausimas = AntrasKlausimas;
        this.TreciasKlausimas = TreciasKlausimas;
        this.KetvirtasKlausimas = KetvirtasKlausimas;
        this.PenktasKlausimas = PenktasKlausimas;
        this.SestasKlausimas = SestasKlausimas;
        this.SeptintasKlausimas = SeptintasKlausimas;
        this.AstuntasKlausimas = AstuntasKlausimas;
        this.DevintasKlausimas = DevintasKlausimas;
        this.DesimtasKlausimas = DesimtasKlausimas;
    }

    public String getPirmasKlausimas() {return PirmasKlausimas;}

    public String getAntrasKlausimas() {
        return AntrasKlausimas;
    }
    public List<String> getTreciasKlausimas() {
        return TreciasKlausimas;
    }

    public List<String> getKetvirtasKlausimas() {
        return KetvirtasKlausimas;
    }
    public String getPenktasKlausimas() {
        return PenktasKlausimas;
    }

    public String getSestasKlausimas() {
        return SestasKlausimas;
    }
    public String getSeptintasKlausimas() {
        return SeptintasKlausimas;
    }

    public List<String> getAstuntasKlausimas() {
        return AstuntasKlausimas;
    }
    public List<String> getDevintasKlausimas() {
        return DevintasKlausimas;
    }

    public String getDesimtasKlausimas() {
        return DesimtasKlausimas;
    }
}
