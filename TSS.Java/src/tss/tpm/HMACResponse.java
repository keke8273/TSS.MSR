package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This command performs an HMAC on the supplied data using the indicated hash algorithm.  */
public class HMACResponse extends TpmStructure
{
    /** The returned HMAC in a sized buffer  */
    public byte[] outHMAC;
    
    public HMACResponse() {}
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeSizedByteBuf(outHMAC);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _outHMACSize = buf.readShort() & 0xFFFF;
        outHMAC = new byte[_outHMACSize];
        buf.readArrayOfInts(outHMAC, 1, _outHMACSize);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static HMACResponse fromBytes (byte[] byteBuf) 
    {
        HMACResponse ret = new HMACResponse();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static HMACResponse fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static HMACResponse fromTpm (InByteBuf buf) 
    {
        HMACResponse ret = new HMACResponse();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_HMAC_RESPONSE");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "byte", "outHMAC", outHMAC);
    }
}

//<<<
