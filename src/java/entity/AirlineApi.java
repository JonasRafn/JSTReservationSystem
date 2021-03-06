package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "airline_api")
@NamedQueries({
    @NamedQuery(name = "AirlineApi.findAll", query = "SELECT a FROM AirlineApi a"),
    @NamedQuery(name = "AirlineApi.findAirline", query = "SELECT a FROM AirlineApi a WHERE a.groupName = :groupName"),
    @NamedQuery(name = "AirlineApi.findbyAirlineName", query = "SELECT a FROM AirlineApi a WHERE a.airlineName = :airlineName")})
public class AirlineApi implements Serializable {

    @Column(name = "group_name")
    @Id
    private String groupName;

    @Column(name = "members")
    private String members;

    @Column(name = "url")
    private String url;

    @Column(name = "airline_name")
    private String airlineName;

    public AirlineApi() {
    }

    public AirlineApi(String groupName, String members, String url, String airlineName) {
        this.groupName = groupName;
        this.members = members;
        this.url = url;
        this.airlineName = airlineName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
}
