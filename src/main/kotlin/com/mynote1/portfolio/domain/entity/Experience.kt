package com.mynote1.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Experience(
    title: String,
    description: String,
    startYear: Int,
    startMonth: Int,
    endYear: Int?,
    endMonth: Int?,
    isActive: Boolean
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    var id: Long? = null

    var title: String = title

    var description: String = description

    var startYear: Int = startYear

    var startMonth: Int = startMonth

    var endYear: Int? = endYear

    var endMonth: Int? = endMonth

    var isActive: Boolean = isActive

    @OneToMany(
        targetEntity = ExperienceDetail::class,
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL]
    ) //영속성 jpa에서 proxy를 쓰는데 이것은 가짜객체라고봄
    @JoinColumn(name = "experience_id")
    var details: MutableList<ExperienceDetail> =
        mutableListOf() //Detail를 가짜 객체로 매핑을 함 위의 LAZY가 가짜 객체를 가지고 있고 호출이되고 쿼리가 오면 호출

    fun getEndYearMonth(): String {
        if (endYear == null || endMonth == null) {
            return "Present"
        }

        return "${endYear}.${endMonth}" //2024.9
    }

    fun update(
        title: String,
        description: String,
        startYear: Int,
        startMonth: Int,
        endYear: Int?,
        endMonth: Int?,
        isActive: Boolean
    ) {
        this.title = title
        this.description = description
        this.startYear = startYear
        this.startMonth = startMonth
        this.endYear = endYear
        this.endMonth = endMonth
        this.isActive = isActive
    }

    fun addDetails(details: MutableList<ExperienceDetail>?) {
        if (details != null) {
            this.details.addAll(details)
        }
    }
}