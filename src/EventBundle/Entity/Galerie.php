<?php

namespace EventBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Galerie
 *
 * @ORM\Table(name="galerie", indexes={@ORM\Index(name="fk_galerie", columns={"idEvent"})})
 * @ORM\Entity
 */
class Galerie
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idGalerie", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idgalerie;

    /**
     * @var \Evenement
     *
     * @ORM\ManyToOne(targetEntity="Evenement")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idEvent", referencedColumnName="idEvent")
     * })
     */
    private $idevent;



    /**
     * Get idgalerie
     *
     * @return integer
     */
    public function getIdgalerie()
    {
        return $this->idgalerie;
    }

    /**
     * Set idevent
     *
     * @param \EventBundle\Entity\Evenement $idevent
     *
     * @return Galerie
     */
    public function setIdevent(\EventBundle\Entity\Evenement $idevent = null)
    {
        $this->idevent = $idevent;

        return $this;
    }

    /**
     * Get idevent
     *
     * @return \EventBundle\Entity\Evenement
     */
    public function getIdevent()
    {
        return $this->idevent;
    }
}
