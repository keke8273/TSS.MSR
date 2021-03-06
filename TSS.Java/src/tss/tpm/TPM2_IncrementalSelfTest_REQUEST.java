package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This command causes the TPM to perform a test of the selected algorithms.  */
public class TPM2_IncrementalSelfTest_REQUEST extends TpmStructure
{
    /** List of algorithms that should be tested  */
    public TPM_ALG_ID[] toTest;
    
    public TPM2_IncrementalSelfTest_REQUEST() {}
    
    /** @param _toTest List of algorithms that should be tested  */
    public TPM2_IncrementalSelfTest_REQUEST(TPM_ALG_ID[] _toTest) { toTest = _toTest; }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeObjArr(toTest);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _toTestCount = buf.readInt();
        toTest = new TPM_ALG_ID[_toTestCount];
        for (int j=0; j < _toTestCount; j++) toTest[j] = TPM_ALG_ID.fromTpm(buf);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static TPM2_IncrementalSelfTest_REQUEST fromBytes (byte[] byteBuf) 
    {
        TPM2_IncrementalSelfTest_REQUEST ret = new TPM2_IncrementalSelfTest_REQUEST();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static TPM2_IncrementalSelfTest_REQUEST fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static TPM2_IncrementalSelfTest_REQUEST fromTpm (InByteBuf buf) 
    {
        TPM2_IncrementalSelfTest_REQUEST ret = new TPM2_IncrementalSelfTest_REQUEST();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_IncrementalSelfTest_REQUEST");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPM_ALG_ID", "toTest", toTest);
    }
}

//<<<
