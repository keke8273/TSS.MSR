package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This command is used to reload a context that has been saved by TPM2_ContextSave().  */
public class TPM2_ContextLoad_REQUEST extends TpmStructure
{
    /** The context blob  */
    public TPMS_CONTEXT context;
    
    public TPM2_ContextLoad_REQUEST() {}
    
    /** @param _context The context blob  */
    public TPM2_ContextLoad_REQUEST(TPMS_CONTEXT _context) { context = _context; }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        context.toTpm(buf);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        context = TPMS_CONTEXT.fromTpm(buf);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static TPM2_ContextLoad_REQUEST fromBytes (byte[] byteBuf) 
    {
        TPM2_ContextLoad_REQUEST ret = new TPM2_ContextLoad_REQUEST();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static TPM2_ContextLoad_REQUEST fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static TPM2_ContextLoad_REQUEST fromTpm (InByteBuf buf) 
    {
        TPM2_ContextLoad_REQUEST ret = new TPM2_ContextLoad_REQUEST();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_ContextLoad_REQUEST");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPMS_CONTEXT", "context", context);
    }
}

//<<<
