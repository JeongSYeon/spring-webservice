package me.yeonbot.webservice.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
//JPA Entity 들이 BaseTimeEntity 클래스를 상속 할 경우 BaseTimeEntity의 필드들도 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class)
//JPA의 Auditing 기능을 포함 시킵니다.
public abstract class BaseTimeEntity {

    @CreatedDate
    //Entity 가 생성 되어 저장 될때 자동으로 시간이 저장 된다.
    private LocalDateTime createdDate;

    //조회한 Entity의 값을 변경할때 시간이 자동 저장 된다.
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
