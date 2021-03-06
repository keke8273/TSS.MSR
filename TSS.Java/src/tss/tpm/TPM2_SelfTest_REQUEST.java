package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This command causes the TPM to perform a test of its capabilities. If the fullTest is
 *  YES, the TPM will test all functions. If fullTest = NO, the TPM will only test those
 *  functions that have not previously been tested.
 */
public class TPM2_SelfTest_REQUEST extends TpmStructure
{
    /** YES if full test to be performed
     *  NO if only test of untested functions required
     */
    public byte fullTest;
    
    public TPM2_SelfTest_REQUEST() {}
    
    /** @param _fullTest YES if full test to be performed
     *         NO if only test of untested functions required
     */
    public TPM2_SelfTest_REQUEST(byte _fullTest) { fullTest = _fullTest; }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeByte(fullTest);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        fullTest = buf.readByte();
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static TPM2_SelfTest_REQUEST fromBytes (byte[] byteBuf) 
    {
        TPM2_SelfTest_REQUEST ret = new TPM2_SelfTest_REQUEST();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static TPM2_SelfTest_REQUEST fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static TPM2_SelfTest_REQUEST fromTpm (InByteBuf buf) 
    {
        TPM2_SelfTest_REQUEST ret = new TPM2_SelfTest_REQUEST();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_SelfTest_REQUEST");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "byte", "fullTest", fullTest);
    }
}

//<<<
