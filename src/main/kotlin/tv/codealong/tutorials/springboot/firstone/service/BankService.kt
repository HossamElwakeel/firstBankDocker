package tv.codealong.tutorials.springboot.firstone.service

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import tv.codealong.tutorials.springboot.firstone.datasource.BankDataSource
import tv.codealong.tutorials.springboot.firstone.model.Bank

@Service
class BankService(private val dataSource: BankDataSource) {

    fun getBanks():Collection<Bank> = dataSource.retrieveBanks();
    fun getBank(accountNumber: String): Bank =dataSource.retrieveBank(accountNumber)
    fun addBank(bank :Bank):Bank = dataSource.createBank(bank)
    fun updateBank(bank:Bank):Bank = dataSource.updateBank(bank)



}