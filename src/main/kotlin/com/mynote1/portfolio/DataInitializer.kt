package com.mynote1.portfolio

import com.mynote1.portfolio.domain.constant.SkillType
import com.mynote1.portfolio.domain.entity.Achievement
import com.mynote1.portfolio.domain.entity.Experience
import com.mynote1.portfolio.domain.entity.ExperienceDetail
import com.mynote1.portfolio.domain.entity.Introduction
import com.mynote1.portfolio.domain.entity.Link
import com.mynote1.portfolio.domain.entity.Project
import com.mynote1.portfolio.domain.entity.ProjectDetail
import com.mynote1.portfolio.domain.entity.ProjectSkill
import com.mynote1.portfolio.domain.entity.Skill

import com.mynote1.portfolio.domain.repository.AchievementRepository
import com.mynote1.portfolio.domain.repository.ExperienceRepository
import com.mynote1.portfolio.domain.repository.IntroductionRepository
import com.mynote1.portfolio.domain.repository.LinkRepository
import com.mynote1.portfolio.domain.repository.ProjectRepository
import com.mynote1.portfolio.domain.repository.SkillRepository
import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Profile(value = ["default"]) //프로필이 Default일때만 h2에서 확인해볼 수 있다.
class DataInitializer(
    private val achievementRepository: AchievementRepository,
    private val experienceRepository: ExperienceRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val projectRepository: ProjectRepository,
    private val skillRepository: SkillRepository

) {

    val log = LoggerFactory.getLogger(DataInitializer::class.java)

    @PostConstruct
    fun initializeData() {

        log.info("스프링이 실행되었습니다. 테스트 데이터를 초기화합니다.")

        // achievement 초기화
        val achievements = mutableListOf<Achievement>(
            Achievement(
                title = "교내로봇대회참여",
                description = "아두이노를 활용한 자율주행로봇",
                host = "캣카오",
                achievedDate = LocalDate.of(2024, 11, 13),
                isActive = true
            ),
            Achievement(
                title = "정보처리기사",
                description = "자료구조, 운영체제, 알고리즘, 데이터베이스 등",
                host = "한국산업인력공단",
                achievedDate = LocalDate.of(2025, 7, 7),
                isActive = true
            )
        )
        achievementRepository.saveAll(achievements)

        // introduction 초기화
        val introductions = mutableListOf<Introduction>(
            Introduction(content = "주도적으로 문제를 찾고, 해결하는 로봇입니다.", isActive = true),
            Introduction(content = "기술을 위한 기술이 아닌, 비즈니스 문제를 풀기 위한 기술을 추구합니다.", isActive = true),
            Introduction(content = "기존 소스를 리팩토링하여 더 좋은 구조로 개선하는 작업을 좋아합니다.", isActive = true)
        )
        introductionRepository.saveAll(introductions)

        // link 초기화
        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/junghyun13", isActive = true),
            Link(name = "Linkedin", content = "https://www.linkedin.com/in/%EC%A0%95%ED%98%84-%EC%9D%B4-1343b9329/", isActive = true),
        )
        linkRepository.saveAll(links)

        // experience / experience_detail 초기화
        val experience1 = Experience(
            title = "수원대학교(Suwon Univ.)",
            description = "정보통신 전공",
            startYear = 2018,
            startMonth = 9,
            endYear = 2022,
            endMonth = 8,
            isActive = true
        )
        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content = "GPA 3.6/4.5", isActive = true),
                ExperienceDetail(content = "SW봉사 활동", isActive = true)
            )
        )
        val experience2 = Experience(
            title = "주식회사 캣카오(Catkao Corp.)",
            description = "소셜서비스팀 백엔드 개발자",
            startYear = 2022,
            startMonth = 9,
            endYear = null,
            endMonth = null,
            isActive = true
        )
        experience2.addDetails(
            mutableListOf(
                ExperienceDetail(content = "유기묘 위치 공유 서비스 개발", isActive = true),
                ExperienceDetail(content = "신입 교육 프로그램 우수상 수상", isActive = true)
            )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2))

        // skill 초기화
        val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGE.name, isActive = true)
        val python = Skill(name = "Python", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
        val django = Skill(name = "Django", type = SkillType.FRAMEWORK.name, isActive = true)
        val mysql = Skill(name = "MySQL", type = SkillType.DATABASE.name, isActive = true)
        val redis = Skill(name = "Redis", type = SkillType.DATABASE.name, isActive = true)
        val kafka = Skill(name = "Kafka", type = SkillType.TOOL.name, isActive = true)
        skillRepository.saveAll(mutableListOf(java, kotlin, python, spring, django, mysql, redis, kafka))

        // project / project_detail / project_skill 초기화

        val project1 = Project(
            name = "유기묘 발견 정보 공유 서비스",
            description = "유기묘 위치의 실시간 공유, 임시보호까지 연결해주는 서비스. 구글 맵스를 연동하여 유기묘 위치 정보를 직관적으로 파악할 수 있도록 하는 사용자 경험 개선 작업.",
            startYear = 2022,
            startMonth = 9,
            endYear = 2022,
            endMonth = 12,
            isActive = true
        )
        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "구글 맵스를 활용한 유기묘 발견 지역 정보 제공 API 개발", url = null, isActive = true),
                ProjectDetail(content = "Redis 적용하여 인기 게시글의 조회 속도 1.5초 → 0.5초로 개선", url = null, isActive = true)
            )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = java),
                ProjectSkill(project = project1, skill = spring),
                ProjectSkill(project = project1, skill = mysql),
                ProjectSkill(project = project1, skill = redis)
            )
        )
        val project2 = Project(
            name = "반려동물 홈 카메라 움직임 감지 분석 모듈",
            description = "카메라에서 서버로 전달되는 신호를 분석하여 움직임이 감지될 경우 클라이언트에게 알림 발송 작업.",
            startYear = 2022,
            startMonth = 12,
            endYear = null,
            endMonth = null,
            isActive = true
        )
        project2.addDetails(
            mutableListOf(
                ProjectDetail(content = "PIL(Pillow) 활용하여 이미지 분석 기능 개발", url = null, isActive = true),
                ProjectDetail(content = "알림 발송을 비동기 처리하여 이미지 분석 - 알림 발송 기능간 의존도 감소", url = null, isActive = true),
                ProjectDetail(content = "Github Repository", url = "https://github.com/infomuscle", isActive = true)
            )
        )
        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project2, skill = python),
                ProjectSkill(project = project2, skill = django),
                ProjectSkill(project = project2, skill = kafka)
            )
        )
        projectRepository.saveAll(mutableListOf(project1, project2))


    }
}