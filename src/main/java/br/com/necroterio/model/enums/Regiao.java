package br.com.necroterio.model.enums;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public enum Regiao {
    FRONTAL("Frontal"),
    ORBITARIAS("Orbitárias"),
    NASAL("Nasal"),
    PARIETAL("Parietal"),
    TEMPORAL("Temporal"),
    MALAR("Malar"),
    ZIGOMATICA("Zigomática"),
    AURICELAR("Auricelular"),
    MASTOIDES("Mastóides"),
    OCOLPITAL("Ocolpital"),
    LABIAL("Labial"),
    MENTONANA("Mentoana"),
    BUCHADORA("Buchadora"),
    MESEATERINA("Maseaterina"),
    SUPRAHIOIDEOS("Supra Hióideos"),
    INFRAHIOIDEOS("Infra Hióideos"),
    CAROTIDIANA("Carotidiana"),
    SUPRACLAVICULAR("Supra Clavicular"),
    NUCA("Nuca"),
    CLAVICULAR("Clavicular"),
    INFRACLAVICULAR("Infra Clavicular"),
    DELTOLDIANA("Deltodiana"),
    TERÇO_SUPERIOR_DO_BRAÇO("Terço Superior do Braço"),
    EXTERNAL("External"),
    MAMARIA("Mamária"),
    MAMILAR("Mamilar"),
    TORÁCICA("Torácica"),
    CONCAVOAXILAR("Cancavo Axilar"),
    HIPOCONDRIO("Hipocôndrio"),
    EPIGASTRICA("Epigástrica"),
    UMBILICAL("Umbilical"),
    MESOGASTRIO("Mesogástrio"),
    FLANCO("Flanco"),
    HIPOGASTRICA("Hipogástrica"),
    FOSSAILIACA("FossaIlíaca"),
    PUBIANA("Pubiana"),
    INGUINAL("Inguinal"),
    CRURAL("Crural"),
    ILIACA("Ilíaca"),
    GLUTEA("Glútea"),
    LINHA_AXLIAR_ANTERIOR("Linha Axliar Anterior"),
    LINHA_AXILIAR_POSTERIOR("Linha Axliar Posterior "),
    ;

    private String descricao;

    Regiao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
