package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This TPM-dependent structure is used to provide the timeout value for an
 *  authorization. The size shall be 8 or less.
 */
public class TPM2B_TIMEOUT extends TpmStructure
{
    /** The timeout value  */
    public byte[] buffer;
    
    public TPM2B_TIMEOUT() {}
    
    /** @param _buffer The timeout value  */
    public TPM2B_TIMEOUT(byte[] _buffer) { buffer = _buffer; }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeSizedByteBuf(buffer);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _size = buf.readShort() & 0xFFFF;
        buffer = new byte[_size];
        buf.readArrayOfInts(buffer, 1, _size);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static TPM2B_TIMEOUT fromBytes (byte[] byteBuf) 
    {
        TPM2B_TIMEOUT ret = new TPM2B_TIMEOUT();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static TPM2B_TIMEOUT fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static TPM2B_TIMEOUT fromTpm (InByteBuf buf) 
    {
        TPM2B_TIMEOUT ret = new TPM2B_TIMEOUT();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2B_TIMEOUT");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "byte", "buffer", buffer);
    }
}

//<<<
