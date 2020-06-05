package demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "album")
public class Album {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(updatable = false)
	protected Long id;

	@Column
	private String title;

	// TODO аннотация @Temporal(TemporalType.DATE) - меняет java поле на указанный в аннотации тип
	@Temporal(TemporalType.DATE)
	@Column(name = "RELEASE_DATE")
	private Date releaseDate;

	// TODO аннотация @ManyToOne (многие к одному - многим альбомам соответствует один певец)
	// в таблице Album будет внешний ключ на таблицу Singer
	@ManyToOne
	@JoinColumn(name = "SINGER_ID", foreignKey = @ForeignKey(name = "fk_foo"))
	private Singer singer;


	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public Singer getSinger() {
		return this.singer;
	}

	public String getTitle() {
		return this.title;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Album - Id: " + id + ", Singer id: " + singer.getId()
				+ ", Title: " + title + ", Release Date: " + releaseDate;
	}
}
