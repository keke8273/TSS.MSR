package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This type is a sized buffer that can hold event data.  */
public class TPM2B_EVENT extends TpmStructure
{
    /** The operand  */
    public byte[] buffer;
    
    public TPM2B_EVENT() {}
    
    /** @param _buffer The operand  */
    public TPM2B_EVENT(byte[] _buffer) { buffer = _buffer; }
    
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
    
    public static TPM2B_EVENT fromBytes (byte[] byteBuf) 
    {
        TPM2B_EVENT ret = new TPM2B_EVENT();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static TPM2B_EVENT fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static TPM2B_EVENT fromTpm (InByteBuf buf) 
    {
        TPM2B_EVENT ret = new TPM2B_EVENT();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2B_EVENT");
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
