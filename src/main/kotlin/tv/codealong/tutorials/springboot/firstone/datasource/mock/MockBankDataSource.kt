package tv.codealong.tutorials.springboot.firstone.datasource.mock

import org.springframework.stereotype.Repository
import tv.codealong.tutorials.springboot.firstone.datasource.BankDataSource
import tv.codealong.tutorials.springboot.firstone.model.Bank

@Repository
class MockBankDataSource : BankDataSource {
    val banks = mutableListOf(Bank("1234",3.14,17),
        Bank("1010",17.0,0),
        Bank("5678",0.0,100)

    )

    override fun retrieveBanks(): Collection<Bank> =banks
    override fun retrieveBank(accountNumber: String): Bank=
        banks.firstOrNull(){ it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account Number $accountNumber")

    override fun createBank(bank: Bank): Bank {
        if(banks.any { it.accountNumber==bank.accountNumber }){
            throw java.lang.IllegalArgumentException("Bank is already exist")
        }
        banks.add(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentBank = banks.firstOrNull { it.accountNumber == bank.accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number ${bank.accountNumber}")
        banks.remove(currentBank)
        banks.add(bank)
        return bank
    }


}