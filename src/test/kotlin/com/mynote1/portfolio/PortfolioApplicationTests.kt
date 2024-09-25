package com.mynote1.portfolio

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PortfolioApplicationTests {

    @Test
    fun contextLoads(){

    }
    /*fun jasypt() {
        val plainText = "dkssudgktpdy"
        val encryptor = PooledPBEStringEncryptor()
        val config = SimpleStringPBEConfig()
        config.password = "q1w2e3"
        config.algorithm = "PBEWithMD5AndDES"
        config.setKeyObtentionIterations("1000")
        config.setPoolSize("1")
        config.providerName = "SunJCE"
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator")
        config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator")
        config.stringOutputType = "base64"
        encryptor.setConfig(config)
        val encryptedText: String = encryptor.encrypt(plainText)
        val decryptedText: String = encryptor.decrypt(encryptedText)
        println(encryptedText)
        println(decryptedText)


    }*/
}
