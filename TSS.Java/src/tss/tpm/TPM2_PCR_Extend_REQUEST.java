package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This command is used to cause an update to the indicated PCR. The digests parameter
 *  contains one or more tagged digest values identified by an algorithm ID. For each
 *  digest, the PCR associated with pcrHandle is Extended into the bank identified by the
 *  tag (hashAlg).
 */
public class TPM2_PCR_Extend_REQUEST extends TpmStructure
{
    /** Handle of the PCR
     *  Auth Handle: 1
     *  Auth Role: USER
     */
    public TPM_HANDLE pcrHandle;
    
    /** List of tagged digest values to be extended  */
    public TPMT_HA[] digests;
    
    public TPM2_PCR_Extend_REQUEST() { pcrHandle = new TPM_HANDLE(); }
    
    /** @param _pcrHandle Handle of the PCR
     *         Auth Handle: 1
     *         Auth Role: USER
     *  @param _digests List of tagged digest values to be extended
     */
    public TPM2_PCR_Extend_REQUEST(TPM_HANDLE _pcrHandle, TPMT_HA[] _digests)
    {
        pcrHandle = _pcrHandle;
        digests = _digests;
    }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeObjArr(digests);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _digestsCount = buf.readInt();
        digests = new TPMT_HA[_digestsCount];
        for (int j=0; j < _digestsCount; j++) digests[j] = new TPMT_HA();
        buf.readArrayOfTpmObjects(digests, _digestsCount);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static TPM2_PCR_Extend_REQUEST fromBytes (byte[] byteBuf) 
    {
        TPM2_PCR_Extend_REQUEST ret = new TPM2_PCR_Extend_REQUEST();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static TPM2_PCR_Extend_REQUEST fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static TPM2_PCR_Extend_REQUEST fromTpm (InByteBuf buf) 
    {
        TPM2_PCR_Extend_REQUEST ret = new TPM2_PCR_Extend_REQUEST();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_PCR_Extend_REQUEST");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPM_HANDLE", "pcrHandle", pcrHandle);
        _p.add(d, "TPMT_HA", "digests", digests);
    }
}

//<<<
