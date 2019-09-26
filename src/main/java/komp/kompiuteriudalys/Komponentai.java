package komp.kompiuteriudalys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Komponentai {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String indiv_pav;
	
	private String tipas;
	
	private String gamintojas;
	
	private String pagam_data;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIndiv_pav() {
		return indiv_pav;
	}

	public void setIndiv_pav(String indiv_pav) {
		this.indiv_pav = indiv_pav;
	}

	public String getTipas() {
		return tipas;
	}

	public void setTipas(String tipas) {
		this.tipas = tipas;
	}

	public String getGamintojas() {
		return gamintojas;
	}

	public void setGamintojas(String gamintojas) {
		this.gamintojas = gamintojas;
	}

	public String getPagam_data() {
		return pagam_data;
	}

	public void setPagam_data(String pagam_data) {
		this.pagam_data = pagam_data;
	}

}
