package net.corda.core.node.services

import net.corda.core.DeleteForDJVM
import net.corda.core.DoNotImplement
import net.corda.core.concurrent.CordaFuture
import net.corda.core.contracts.Attachment
import net.corda.core.transactions.LedgerTransaction

/**
 * Provides verification service. The implementation may be a simple in-memory verify() call or perhaps an IPC/RPC.
 * @suppress
 */
@DoNotImplement
@DeleteForDJVM
interface TransactionVerifierService {
    /**
     * @param transaction The transaction to be verified.
     * @return A future that completes successfully if the transaction verified, or sets an exception the verifier threw.
     */
    fun verify(transaction: LedgerTransaction): CordaFuture<*>

    /**
     * Verifies the [transaction] but adds some [extraAttachments] to the classpath.
     * Required for transactions build with Corda 3.x that might miss some dependencies.
     */
    fun verify(transaction: LedgerTransaction, extraAttachments: List<Attachment> ): CordaFuture<*>
}