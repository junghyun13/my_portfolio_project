package com.mynote1.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ProjectSkill(project: Project, skill: Skill) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_skill_id")
    var id: Long? = null

    @ManyToOne(targetEntity = Project::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false) //join의 기준이 프로젝트 아이디이다.
    var project: Project = project

    @ManyToOne(targetEntity = Skill::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id", nullable = false)
    var skill: Skill = skill

}