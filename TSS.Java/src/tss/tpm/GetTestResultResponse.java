package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This command returns manufacturer-specific information regarding the results of a
 *  self-test and an indication of the test status.
 */
public class GetTestResultResponse extends TpmStructure
{
    /** Test result data
     *  contains manufacturer-specific information
     */
    public byte[] outData;
    
    public TPM_RC testResult;
    
    public GetTestResultResponse() {}
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeSizedByteBuf(outData);
        testResult.toTpm(buf);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _outDataSize = buf.readShort() & 0xFFFF;
        outData = new byte[_outDataSize];
        buf.readArrayOfInts(outData, 1, _outDataSize);
        testResult = TPM_RC.fromTpm(buf);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static GetTestResultResponse fromBytes (byte[] byteBuf) 
    {
        GetTestResultResponse ret = new GetTestResultResponse();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static GetTestResultResponse fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static GetTestResultResponse fromTpm (InByteBuf buf) 
    {
        GetTestResultResponse ret = new GetTestResultResponse();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_GetTestResult_RESPONSE");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "byte", "outData", outData);
        _p.add(d, "TPM_RC", "testResult", testResult);
    }
}

//<<<
