package tv.codealong.tutorials.springboot.firstone.service

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import tv.codealong.tutorials.springboot.firstone.datasource.BankDataSource

internal class BankServiceTest{
    private val dataSource:BankDataSource = mockk(relaxed =true)
    private val bankService=BankService(dataSource)

    @Test
    fun shouldCallItsDataSourceToRetrieveBanks(){

      bankService.getBanks()

       verify (exactly=1){dataSource.retrieveBanks()}
    }

}