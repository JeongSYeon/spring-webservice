package me.yeonbot.webservice.domain.posts;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.yeonbot.webservice.domain.BaseTimeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
//기본 생성자 자동 추가 , 기본 생성자의 접근 권한을 protected 로 제한
//protected Posts (){ } 와 같은 효과
//프로젝트 코드상 생성를 막고, JPA에서 Entity 클래스를 생성하는 것은 허용한다.
@Getter
//클래스 내의 모든 필드의 Getter 메소드 자동 생성  LOMBOK
@Entity
//테이블과 링크될 클래스 임을 나타낸다.
//언더 스코어 네이밍 으로 매칭
//ex) AbcDef -> abc_def
public class Posts extends BaseTimeEntity {

    @Id //id 변수가 primary key 임을 나타낸다.
    @GeneratedValue //primary key 값 생성 규칙 . default 로는 auto_increment 와 같이 자동 증가하는 정수형 값
    private Long id;

    @Column(length = 500, nullable = false) //기본 크기 255 -> 500 변경
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) //타입 변경 , 널값 허용
    private String content;

    //아무것도 없다면 기본 Column 이 디폴트 값 ,다른 값을 추가 하고 싶다면 위처럼 사용
    private String author;


    //Builder 역할 : 해당 클래스의 빌더패턴 클래스를 생성 .
    //생성자 상단에 선언시 생성자에 포한된 필드만 빌더에 포함.
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
