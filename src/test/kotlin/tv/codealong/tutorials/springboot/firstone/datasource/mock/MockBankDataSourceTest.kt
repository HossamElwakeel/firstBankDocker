package tv.codealong.tutorials.springboot.firstone.datasource.mock

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MockBankDataSourceTest{
    private val mockDataSource=MockBankDataSource()
    @Test
     fun shouldProvideACollectionOfBanks() {
        val banks = mockDataSource.retrieveBanks()
        assertThat(banks).isNotEmpty
    }
    @Test
    fun shouldProvideSomeMockData(){
        val banks = mockDataSource.retrieveBanks()
        assertThat(banks).allSatisfy{it.accountNumber.isNotBlank()}
    }

}